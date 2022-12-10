package fk.vue.component.action;

import com.intellij.openapi.project.Project;
import fk.util.AbstractCreatorAction;
import fk.util.AbstractDialog;
import fk.vue.component.data.ComponentSettingsState;
import fk.vue.component.ui.ComponentCreatorDialog;

public class ComponentCreatorAction extends AbstractCreatorAction {
    protected AbstractDialog createDialog(Project project) {
        ComponentSettingsState state = ComponentSettingsState.getInstance(project);
        System.out.println(state);
        return new ComponentCreatorDialog(state.getOptions());
    }
}
