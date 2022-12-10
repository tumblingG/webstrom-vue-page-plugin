package fk.vue.tscomponent.data;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import fk.util.AbstractPersistentState;

@State(
        name = "TsPageSettings",
        storages = {
                @Storage("/vbb.xml")
        }
)
public class TsComponentSettingsState extends AbstractPersistentState<TsComponentCreatorOptions>{
    public TsComponentSettingsState() {
        super(new TsComponentCreatorOptions());
    }

    public static TsComponentSettingsState getInstance(Project project) {
        return ServiceManager.getService(project, TsComponentSettingsState.class);
    }
}
