package winApp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

public class MainWindow {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text username;
	private Text password;
	private String userName = null;

	   private String pass = null;


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(450, 477);
		shell.setText("SWT Application");
		
		Label lblNewLabel = formToolkit.createLabel(shell, "New Label", SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		lblNewLabel.setImage(SWTResourceManager.getImage(MainWindow.class, "/winApp/business-user-icon-44613.png"));
		lblNewLabel.setBounds(106, 0, 246, 258);
		
		Label lblNewLabel_1 = formToolkit.createLabel(shell, "Username", SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setBounds(51, 299, 71, 17);
		
		Label lblNewLabel_2 = formToolkit.createLabel(shell, "Password", SWT.NONE);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_2.setBounds(51, 336, 71, 17);
		
		username = new Text(shell, SWT.BORDER);
		username.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		username.setBounds(183, 299, 170, 25);
		formToolkit.adapt(username, true, true);
		
		password = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		password.setTouchEnabled(true);
		password.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		password.setBounds(183, 328, 170, 25);
		formToolkit.adapt(password, true, true);
		
		Button btnNewButton = new Button(shell, SWT.BORDER | SWT.FLAT | SWT.CENTER);
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 userName = username.getText();
				 pass = password.getText();
				 int style = SWT.ICON_INFORMATION;
					int style2 = SWT.ICON_ERROR;
				 if (userName.contains("fatima") && pass.contains("eva")) {
					 username.setText("");
					 password.setText("");
					 System.out.println("bienvenu");
					 MessageBox messageBox = new MessageBox(shell,style);
						messageBox.setMessage("Bienvenu !");
						messageBox.open();} else {
							 MessageBox messageBox = new MessageBox(shell,style2);
								messageBox.setMessage(" le remplisage est erroné !");
								messageBox.open();
							
						}
				 }
				 
				         });

		btnNewButton.setBounds(183, 385, 107, 25);
		formToolkit.adapt(btnNewButton, true, true);
		btnNewButton.setText("Login");
		
		DropTarget dropTarget = new DropTarget(shell, DND.DROP_MOVE);

	}
}
