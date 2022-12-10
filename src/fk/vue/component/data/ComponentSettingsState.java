package fk.vue.component.data;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import fk.util.AbstractPersistentState;

@State(
        name = "PageSettings",
        storages = {
                @Storage("/vbb.xml")
        }
)
public class ComponentSettingsState extends AbstractPersistentState<fk.vue.component.data.ComponentCreateOptions> {

    public ComponentSettingsState() {
        super(new fk.vue.component.data.ComponentCreateOptions());
    }

    public static fk.vue.component.data.ComponentSettingsState getInstance(Project project) {
        return ServiceManager.getService(project, fk.vue.component.data.ComponentSettingsState.class);
    }
}
