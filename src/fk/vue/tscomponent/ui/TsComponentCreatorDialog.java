package fk.vue.tscomponent.ui;

import fk.util.AbstractDialog;
import fk.vue.tscomponent.data.*;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class TsComponentCreatorDialog extends AbstractDialog<TsComponentCreatorOptions> {
    private JButton buttonOK;
    private JTextField componentNameTextField;
    private JCheckBox htmlCheckbox;
    private JCheckBox lessCheckbox;
    private JPanel contentPane;

    public TsComponentCreatorDialog(TsComponentCreatorOptions opt) {
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
    public TsComponentCreatorOptions setOptions(TsComponentCreatorOptions options) {
        options.setComponentName(componentNameTextField.getText());
        options.setCreateHtmlFile(htmlCheckbox.isSelected());
        options.setCreateLessFile(lessCheckbox.isSelected());
        return options;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
