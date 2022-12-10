package fk.vue.tscomponent.data;

import fk.util.AbstractOptions;
import fk.util.StringFormatter;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TsComponentCreatorOptions extends AbstractOptions {
    public static final String STORE_KEY = "fs.ts.page";
    public static final String COMPONENT_TEMPLATE_KEY = "COMPONENT_TEMPLATE_KEY";
    public static final String LESS_TEMPLATE_KEY = "LESS_TEMPLATE_KEY";
    public static final String HTML_TEMPLATE_KEY = "HTML_TEMPLATE_KEY";

    private final String defaultComponentTemplateFile = "templates/ts-component/{{componentName}}.vue.mustache";
    private final String defaultLessTemplateFile = "templates/ts-component/{{componentName}}.less.mustache";
    private final String defaultHtmlTemplateFile = "templates/ts-component/{{componentName}}.html.mustache";

    private String componentTemplateFile = defaultComponentTemplateFile;
    private String lessTemplateFile = defaultLessTemplateFile;
    private String htmlTemplateFile = defaultHtmlTemplateFile;

    private boolean createLessFile = false;
    private boolean createHtmlFile = false;

    private String componentName;

    @Override
    public ArrayList<String> getFiles() {
        ArrayList<String> files = new ArrayList<>();
        files.add(componentTemplateFile);

        if (createLessFile) {
            files.add(lessTemplateFile);
        }

        if (createHtmlFile) {
            files.add(htmlTemplateFile);
        }
        return files;
    }

    @Override
    public Map<String, Object> getTemplateVariables() {
        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("componentName", componentName);
        templateModel.put("componentNameCamelCase", StringFormatter.capitalizeFirst(StringFormatter.toCamelCase(componentName)));
        return templateModel;
    }

    @Override
    public Element serialize() {
        final Element element = new Element(STORE_KEY);
        element.setAttribute(COMPONENT_TEMPLATE_KEY, componentTemplateFile);
        element.setAttribute(LESS_TEMPLATE_KEY, lessTemplateFile);
        element.setAttribute(HTML_TEMPLATE_KEY, htmlTemplateFile);
        return element;
    }

    @Override
    public void deserialize(Element element) {
        setComponentTemplateFile(element.getAttributeValue(COMPONENT_TEMPLATE_KEY));
        setLessTemplateFile(element.getAttributeValue(LESS_TEMPLATE_KEY));
        setHtmlTemplateFile(element.getAttributeValue(HTML_TEMPLATE_KEY));
    }

    public boolean isComponentTemplateDefault() {
        return defaultComponentTemplateFile.equals(componentTemplateFile);
    }

    public boolean isSassTemplateDefault() {
        return defaultLessTemplateFile.equals(lessTemplateFile);
    }

    public boolean isStorybookTemplateDefault() {
        return defaultHtmlTemplateFile.equals(htmlTemplateFile);
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentTemplateFile() {
        return componentTemplateFile;
    }

    public void setComponentTemplateFile(String componentTemplateFile) {
        if (componentTemplateFile == null || componentTemplateFile.isEmpty()) {
            this.componentTemplateFile = defaultComponentTemplateFile;
            return;
        }
        this.componentTemplateFile = componentTemplateFile;
    }

    public String getLessTemplateFile() {
        return lessTemplateFile;
    }

    public void setLessTemplateFile(String lessTemplateFile) {
        if (lessTemplateFile == null || lessTemplateFile.isEmpty()) {
            this.lessTemplateFile = defaultLessTemplateFile;
            return;
        }
        this.lessTemplateFile = lessTemplateFile;
    }

    public String getHtmlTemplateFile() {
        return htmlTemplateFile;
    }

    public void setHtmlTemplateFile(String htmlTemplateFile) {
        if (htmlTemplateFile == null || htmlTemplateFile.isEmpty()) {
            this.htmlTemplateFile = defaultHtmlTemplateFile;
            return;
        }
        this.htmlTemplateFile = htmlTemplateFile;
    }

    public boolean isCreateLessFile() {
        return createLessFile;
    }

    public void setCreateLessFile(boolean createLessFile) {
        this.createLessFile = createLessFile;
    }

    public boolean isCreateHtmlFile() {
        return createHtmlFile;
    }

    public void setCreateHtmlFile(boolean createHtmlFile) {
        this.createHtmlFile = createHtmlFile;
    }

    public boolean equals(TsComponentCreatorOptions options) {
        return (options.getComponentTemplateFile().equals(componentTemplateFile)
                && options.getHtmlTemplateFile().equals(htmlTemplateFile)
                && options.getLessTemplateFile().equals(lessTemplateFile)
        );
    }

}
