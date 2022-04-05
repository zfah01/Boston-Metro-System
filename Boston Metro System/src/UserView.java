
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserView {

    private MetroSystem metroSystem;

    private JComboBox fromStation;
    private JComboBox toStation;
    private DefaultListModel routeListModel;

    public void buildPanel() {

        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jframe.setTitle("MetroSystem");

        jframe.setSize(500,500);
        jframe.setResizable(false);
        Container contentPane = jframe.getContentPane();
        SpringLayout springLayout = new SpringLayout();
        jframe.setLayout(springLayout);

        JButton showRouteButton = new JButton("Show Route");
        //JButton buttonTwo = new JButton("Remove Station");
        //JButton buttonThree = new JButton("Add Station");
        JButton clearButton = new JButton("Clear");
        JLabel routeLabel = new JLabel("Route:");
        JLabel labelfrom = new JLabel("From station:");
        JLabel labelto = new JLabel("To station:");
        fromStation = new JComboBox();
        toStation = new JComboBox();
        JLabel map = new JLabel(new ImageIcon("Boston Metro System/src/map.jpg"));

        //showRouteButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        routeListModel = new DefaultListModel();
        JList routeList = new JList(routeListModel);

        JScrollPane sp = new JScrollPane(routeList);
        sp.setViewportView(routeList);
        routeList.setLayoutOrientation(JList.VERTICAL);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(sp);

        sp.setPreferredSize(new Dimension(350, 200));
        routeList.setVisibleRowCount(10);
        routeList.setFixedCellWidth(200);
        routeList.setFixedCellHeight(12);

        contentPane.add(labelfrom);
        contentPane.add(fromStation);
        contentPane.add(labelto);
        contentPane.add(toStation);
        contentPane.add(showRouteButton);
        contentPane.add(routeLabel);
        //contentPane.add(routeList);
        contentPane.add(clearButton);
        contentPane.add(map);


        springLayout.putConstraint(SpringLayout.WEST, labelfrom, 5, SpringLayout.WEST, contentPane);
        springLayout.putConstraint(SpringLayout.NORTH, labelfrom, 8, SpringLayout.NORTH, contentPane);
        springLayout.putConstraint(SpringLayout.WEST, fromStation, 5, SpringLayout.EAST, labelfrom);
        springLayout.putConstraint(SpringLayout.NORTH, fromStation, 5, SpringLayout.NORTH, contentPane);


        springLayout.putConstraint(SpringLayout.WEST, labelto, 5, SpringLayout.WEST, contentPane);
        springLayout.putConstraint(SpringLayout.NORTH, labelto, 15, SpringLayout.SOUTH, labelfrom);
        springLayout.putConstraint(SpringLayout.WEST, toStation, 20, SpringLayout.EAST, labelto);
        springLayout.putConstraint(SpringLayout.NORTH, toStation, 5, SpringLayout.SOUTH, fromStation);

        springLayout.putConstraint(SpringLayout.WEST, showRouteButton, 200, SpringLayout.WEST, contentPane);
        springLayout.putConstraint(SpringLayout.NORTH, showRouteButton, 10, SpringLayout.SOUTH, toStation);

        springLayout.putConstraint(SpringLayout.WEST, routeLabel, 5, SpringLayout.WEST, contentPane);
        springLayout.putConstraint(SpringLayout.NORTH, routeLabel, 20, SpringLayout.SOUTH, showRouteButton);

        springLayout.putConstraint(SpringLayout.WEST, sp, 5, SpringLayout.WEST, contentPane);
        springLayout.putConstraint(SpringLayout.NORTH, sp, 10, SpringLayout.SOUTH, routeLabel);

        springLayout.putConstraint(SpringLayout.WEST, clearButton, 5, SpringLayout.WEST, contentPane);
        springLayout.putConstraint(SpringLayout.NORTH, clearButton, 10, SpringLayout.SOUTH, sp);

        springLayout.putConstraint(SpringLayout.EAST, map, -10, SpringLayout.EAST, contentPane);
        springLayout.putConstraint(SpringLayout.SOUTH, map, 5, SpringLayout.SOUTH, contentPane);
        springLayout.putConstraint(SpringLayout.NORTH, map, 5, SpringLayout.NORTH, contentPane);
        springLayout.putConstraint(SpringLayout.WEST, map, 5, SpringLayout.EAST, sp);

        springLayout.putConstraint(SpringLayout.EAST, contentPane, 800, SpringLayout.WEST, contentPane);
        springLayout.putConstraint(SpringLayout.SOUTH, contentPane, 500, SpringLayout.NORTH, contentPane);

        showRouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                getRouteAndShowResult();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                routeListModel.clear();
                fromStation.setSelectedIndex(0);
                toStation.setSelectedIndex(1);
            }
        });

        populateComboBox();
        jframe.pack();
        jframe.setVisible(true);
    }

    private void getRouteAndShowResult(){
        routeListModel.clear();
        Node fromNode = (Node) fromStation.getSelectedItem();
        Node toNode = (Node) toStation.getSelectedItem();
        if (fromNode.getNodeID() == toNode.getNodeID()){
            routeListModel.addElement("Origin is same as destination");
            return;
        }
        List<Node> route = metroSystem.getRoute(fromNode.getNodeID(), toNode.getNodeID());
        if (route == null){
            routeListModel.addElement("No route found");
            return;
        }
        routeListModel.addElement(new String(route.size()-1 + " stops from "+ fromNode.getNodeName() + " to " + toNode.getNodeName()));
        for (int i=0; i < route.size(); i++){
            Node n = route.get(i);
            if (i == 0)
                routeListModel.addElement("Start at: " + n.getNodeName());
            else if (i == route.size()-1)
                routeListModel.addElement("Arrive at: " + n.getNodeName());
            else
                routeListModel.addElement("Go to: " + n.getNodeName());
            }


    }

    private void populateComboBox(){
        List<Node> allStations = metroSystem.getAllStations();
        for (Node node: allStations){
            fromStation.addItem(node);
            toStation.addItem(node);
        }
        toStation.setSelectedIndex(1);
    }

    public void setUpMetroSystem(){
        metroSystem = new MetroSystem();
        metroSystem.loadFromFile();

    }

    public static void main(String[] args){
        UserView view = new UserView();
        view.setUpMetroSystem();
        view.buildPanel();


    }



}
