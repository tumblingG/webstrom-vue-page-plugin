package fk.vue.component.data;

import fk.util.AbstractOptions;
import fk.util.StringFormatter;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComponentCreateOptions extends AbstractOptions {
    public static final String STORE_KEY = "vcc.page";
    public static final String COMPONENT_TEMPLATE_KEY = "COMPONENT_TEMPLATE_KEY";
    public static final String SASS_TEMPLATE_KEY = "SASS_TEMPLATE_KEY";
    public static final String STORYBOOK_TEMPLATE_KEY = "STORYBOOK_TEMPLATE_KEY";

    private final String defaultComponentTemplateFile = "templates/component/{{componentName}}.vue.mustache";
    private final String defaultSassTemplateFile = "templates/component/_{{componentName}}.less.mustache";
    private final String defaultStorybookTemplateFile = "templates/component/_{{componentName}}.js.mustache";

    private String componentTemplateFile = defaultComponentTemplateFile;
    private String sassTemplateFile = defaultSassTemplateFile;
    private String storybookTemplateFile = defaultStorybookTemplateFile;

    private boolean createSassFile = false;
    private boolean createStorybookFile = false;

    private String componentName;

    @Override
    public ArrayList<String> getFiles() {
        ArrayList<String> files = new ArrayList<>();
        files.add(componentTemplateFile);

        if (createSassFile) {
            files.add(sassTemplateFile);
        }

        if (createStorybookFile) {
            files.add(storybookTemplateFile);
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
        element.setAttribute(SASS_TEMPLATE_KEY, sassTemplateFile);
        element.setAttribute(STORYBOOK_TEMPLATE_KEY, storybookTemplateFile);
        return element;
    }

    @Override
    public void deserialize(Element element) {
        setComponentTemplateFile(element.getAttributeValue(COMPONENT_TEMPLATE_KEY));
        setSassTemplateFile(element.getAttributeValue(SASS_TEMPLATE_KEY));
        setStorybookTemplateFile(element.getAttributeValue(STORYBOOK_TEMPLATE_KEY));
    }

    public boolean isComponentTemplateDefault() {
        return defaultComponentTemplateFile.equals(componentTemplateFile);
    }

    public boolean isSassTemplateDefault() {
        return defaultSassTemplateFile.equals(sassTemplateFile);
    }

    public boolean isStorybookTemplateDefault() {
        return defaultStorybookTemplateFile.equals(storybookTemplateFile);
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

    public String getSassTemplateFile() {
        return sassTemplateFile;
    }

    public void setSassTemplateFile(String sassTemplateFile) {
        if (sassTemplateFile == null || sassTemplateFile.isEmpty()) {
            this.sassTemplateFile = defaultSassTemplateFile;
            return;
        }
        this.sassTemplateFile = sassTemplateFile;
    }

    public String getStorybookTemplateFile() {
        return storybookTemplateFile;
    }

    public void setStorybookTemplateFile(String storybookTemplateFile) {
        if (storybookTemplateFile == null || storybookTemplateFile.isEmpty()) {
            this.storybookTemplateFile = defaultStorybookTemplateFile;
            return;
        }
        this.storybookTemplateFile = storybookTemplateFile;
    }

    public boolean isCreateSassFile() {
        return createSassFile;
    }

    public void setCreateSassFile(boolean createSassFile) {
        this.createSassFile = createSassFile;
    }

    public boolean isCreateStorybookFile() {
        return createStorybookFile;
    }

    public void setCreateStorybookFile(boolean createStorybookFile) {
        this.createStorybookFile = createStorybookFile;
    }

    public boolean equals(fk.vue.component.data.ComponentCreateOptions options) {
        return (options.getComponentTemplateFile().equals(componentTemplateFile)
                && options.getStorybookTemplateFile().equals(storybookTemplateFile)
                && options.getSassTemplateFile().equals(sassTemplateFile)
        );
    }
}
