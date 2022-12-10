package fk.vue.tscomponent.action;

import com.intellij.openapi.project.Project;
import fk.util.AbstractCreatorAction;
import fk.util.AbstractDialog;
import fk.vue.tscomponent.data.TsComponentSettingsState;
import fk.vue.tscomponent.ui.TsComponentCreatorDialog;

public class TsComponentCreatorAction extends AbstractCreatorAction {

    protected AbstractDialog createDialog(Project project) {
        TsComponentSettingsState state = TsComponentSettingsState.getInstance(project);
        return new TsComponentCreatorDialog(state.getOptions());
    }
}
