import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class MenuBar extends JMenuBar implements ActionListener{

    private JMenu Options, Help;
    private JMenuItem newGame, saver, loader, helper;
    public MenuBar() {
	   
    //Initializing JMenus
    
	Options = new JMenu("Options");
	Help = new JMenu("Help");
    
    
	//Initializing Options JMenuItems
    
	newGame = new JMenuItem("New Game");
//	newGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
    
	saver = new JMenuItem("Save");
//	saver.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));

	loader = new JMenuItem("Load");
//	loader.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
    
	Options.add(newGame);
	Options.add(saver);
	Options.add(loader);
    
    
	//Initializing Help JMenuItems

	helper = new JMenuItem("Help");
//	helper.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
    
	Help.add(helper);
    
	
	//Adding MenuListeners
	newGame.addActionListener(this);
	saver.addActionListener(this);
	loader.addActionListener(this);
    
	helper.addActionListener(this);

	//Adding Menus to MenuBar

	this.add(Options);
	this.add(Box.createHorizontalStrut(15));
	this.add(Help);
    }
	

    public void actionPerformed(ActionEvent e) {
	if (e.getActionCommand().equals("New Game")){
	    //new Paint("images/color/Black.png");
        Main.newGame();
	}
	if (e.getActionCommand().equals("Save")){
	    //fileName = FileChooser.main();
	    //new Paint(fileName);
	}
	if (e.getActionCommand().equals("Load")){
	    //new SaveAsWindow(paint);
	}	
    if (e.getActionCommand().equals("Help")){
	 //   paint.clear();
	}
    }

}
