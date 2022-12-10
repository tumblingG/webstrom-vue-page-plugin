package fk.vue.component.ui;

import fk.util.AbstractDialog;
import fk.vue.component.data.ComponentCreateOptions;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ComponentCreatorDialog extends AbstractDialog<ComponentCreateOptions> {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField componentNameTextField;
    private JCheckBox storybookFileCheckbox;
    private JCheckBox scssFileCheckbox;

    public ComponentCreatorDialog(ComponentCreateOptions opt) {
        super(opt);
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    public String getComponentName() {
        return componentNameTextField.getText();
    }

    @Override
    public String getDirectoryName() {
        return componentNameTextField.getText();
    }

    @Override
    public ComponentCreateOptions setOptions(ComponentCreateOptions options) {
        options.setComponentName(componentNameTextField.getText());
        options.setCreateSassFile(scssFileCheckbox.isSelected());
        options.setCreateStorybookFile(storybookFileCheckbox.isSelected());
        return options;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
