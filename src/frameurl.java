import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.*;
import java.io.*;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class frameurl {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameurl window = new frameurl();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frameurl() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 408);
		frame.setTitle("EXPORT JSON FROM URL");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUrl = new JLabel("Url");
		lblUrl.setBounds(10, 11, 82, 14);
		frame.getContentPane().add(lblUrl);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 499, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblResponce = new JLabel("JSON Responce");
		lblResponce.setBounds(10, 67, 116, 14);
		frame.getContentPane().add(lblResponce);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 598, 200);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		
		JButton btnNewButton = new JButton("Get Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getJSONData(textField.getText().toString(),textArea);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(519, 35, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 302, 598, 23);
		frame.getContentPane().add(progressBar);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"CSV", "XML", "PDF", "DOC"}));
		spinner.setBounds(10, 336, 116, 20);
		frame.getContentPane().add(spinner);
		
		JButton btnExportJson = new JButton("EXPORT JSON");
		btnExportJson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportJSON(spinner.getValue().toString(),textArea.getText());
			}
		});
		btnExportJson.setBounds(471, 336, 137, 23);
		frame.getContentPane().add(btnExportJson);
		frame.setVisible(true);
	}


	protected void exportJSON(String filetype, String text) {
		switch (filetype) {
			case "CSV":
			{
				jsontocsv(text);
			}
			case "DOC":
			{
				jsontodoc(text);
			}
			case "PDF":
			{
				jsontopdf(text);
			}
			case "XML":
			{
				jsontoxml(text);
			}
		}
		
	}

	private void jsontoxml(String text) {
		
		JSONObject json = new JSONObject(text);
		String Xml = XML.toString(json);
		System.out.println(Xml);
//		try {
//			stringToDom(Xml);
//		} catch (SAXException | ParserConfigurationException | IOException | TransformerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	public static void stringToDom(String xmlSource) 
	        throws SAXException, ParserConfigurationException, IOException, TransformerException {
	    // Parse the given input
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document doc = builder.parse(new InputSource(new StringReader(xmlSource)));

	    // Write the parsed document to an xml file
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(doc);

	    StreamResult result =  new StreamResult(new File("gg.xml"));
	    transformer.transform(source, result);
	}

	private void jsontopdf(String text) {
		// TODO Auto-generated method stub
		
	}

	private void jsontodoc(String text) {
		// TODO Auto-generated method stub
		
	}

	private void jsontocsv(String text) {
		// TODO Auto-generated method stub
		
	}

	protected void getJSONData(String Texturl,JTextArea txtArea) throws IOException {
		
		
		URL url = new URL(Texturl);
		URLConnection request = url.openConnection();
		request.connect();
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String inputLine ;
		
        while ((inputLine = in.readLine()) != null) 
            txtArea.setText(inputLine );        	
        in.close();
         
        
        
	}
}
