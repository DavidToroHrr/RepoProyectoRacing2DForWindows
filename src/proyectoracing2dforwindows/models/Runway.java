/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author usuario
 */
public class Runway extends Sprite{

    /**
     * @return the circuit
     */
    public ArrayList<ArrayList<Cell>> getCircuit() {
        return circuit;
    }

    /**
     * @param circuit the circuit to set
     */
    public void setCircuit(ArrayList<ArrayList<Cell>> circuit) {
        this.circuit = circuit;
    }
    private String name;
    private String description;
    private ArrayList<String> circuitStr;
    private ArrayList<ArrayList<Cell>> circuit;
    private ArrayList<BufferedImage> cellImages;
    
    private final int CELL_IMAGE_TRAIL = 0;
    private final int CELL_IMAGE_BORDER = 1;
    private final int CELL_IMAGE_GRASS = 2;
    private final int CELL_IMAGE_WALL = 3;
    private final int CELL_IMAGE_FINISH = 4;
    private final int CELL_IMAGE_CHECKPOINT = 5;
    
    private ArrayList<Checkpoint> checkPoints;

    public Runway(int x, int y, int width, int height, String name, 
            String description, ArrayList<String> circuitStr, ArrayList<String> checkpoints_measures) {
        super(x, y, width, height);
        this.name = name;
        this.description = description;
        this.circuit = new ArrayList<>();
        this.circuitStr = circuitStr;
        
        cellImages = new ArrayList<>();
        String path = "src/data/resources/runway/";
        
        cellImages.add(loadImage(path+"trail.jpg"));
        cellImages.add(loadImage(path+"border.jpg"));
        cellImages.add(loadImage(path+"grass.jpg"));
        cellImages.add(loadImage(path+"wall.jpg"));
        cellImages.add(loadImage(path+"finish.jpg"));
        cellImages.add(loadImage(path+"checkpoint.jpg"));
        
        checkPoints = new ArrayList<>();
        configCheckpoints(checkpoints_measures);
    }
    
    public void configCircuit(){
        int x = this.getX();
        int y = this.getY();
        int size = Cell.SIZE;
        
        for(String rowS : circuitStr){
            
            ArrayList<Cell> rowC = new ArrayList<>();
            try{
                for (char item : rowS.toCharArray()) {
                    Cell cell;
                    cell = null;
                    
                    if (item == 'T') {
                        cell = new CellTrail(x, y, cellImages.get(CELL_IMAGE_TRAIL));
                    }
                    if (item == 'B') {
                        cell = new CellBorder(x, y, cellImages.get(CELL_IMAGE_BORDER));
                    }
                    if (item == 'G') {
                        cell = new CellGrass(x, y, cellImages.get(CELL_IMAGE_GRASS));
                    }
                    if (item == 'W') {
                        cell = new CellWall(x, y, cellImages.get(CELL_IMAGE_WALL));
                    }
                    if (item == 'F') {
                        cell = new CellFinish(x, y, cellImages.get(CELL_IMAGE_FINISH));
                    }
                    if (item == 'C') {
                        cell = new CellCheckPoint(x, y, cellImages.get(CELL_IMAGE_CHECKPOINT));
                    }

                    rowC.add(cell);
                    x += size;
                }
                
                this.getCircuit().add(rowC);
                x = this.getX();
                y += size;
            } catch (IOException ex) {
                    Logger.getLogger(Runway.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
    }
/**
* .Runway#verifyPoint(int x,int y)
* Este método se encarga de verificar si unas coordenadas generadas aleatoreamente chochan la pista 
* o no la chocan, esto con el fin de solo generar allí objetos especiales.
* @param x:Indica la posición en X posible del objeto especial
* @param y:Indica la posición en Y posible del objeto especial
* @return: retorna un booleano que indica si chocó pista o celltrail
*/
    public boolean verifyPoint(int x,int y){//aqui vamos a recorrer la pista
        for (ArrayList<Cell> arrayList : circuit) {
            for (Cell cell : arrayList) {
                    if (cell.verifyTouchCell(x, y) & cell.getId().equals("celltrail")) {
                            return true;

                    }
                     
                     
                
            }
        }
        return false;
    
    }
    
    public Cell verifyCellCollision(int x2,int y2,int width2,int height2){
        for(ArrayList<Cell> row : circuit){
            for(Cell cell : row){
                if(cell.verifyCollision(x2, y2, width2, height2)){
                    return cell;
                }
            }
        }
        return null;
    }
    
    public int verifyCheckpointCollision(int x2,int y2,int width2,int height2){
        for(Checkpoint cp : checkPoints){
            if(cp.verifyCollision(x2, y2, width2, height2)){
                return cp.getPriority();
            }
        }
        
        return -1;
    }
    
    private BufferedImage loadImage(String path){
        File file = new File(path);
        BufferedImage cellImage = null;
        try {
            cellImage = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(GameObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cellImage;
    }
    
    private void configCheckpoints(ArrayList<String> checkpoints_measures){
        int priority = 0;
        int size = Cell.SIZE;
        for(String line : checkpoints_measures){
            String[] measures = line.split(":");
            int cpX = Integer.parseInt(measures[0])*size;
            int cpY = Integer.parseInt(measures[1])*size;
            int cpWidth = Integer.parseInt(measures[2])*size;
            int cpHeight = Integer.parseInt(measures[3])*size;
            Checkpoint checkpoint = new Checkpoint(cpX, cpY, cpWidth, cpHeight, priority);
            checkPoints.add(checkpoint);
            priority += 1;
        }
    }

    @Override
    public void draw(Graphics g) {
        for(ArrayList<Cell> row : getCircuit()){
            for(Cell cell : row){
                cell.draw(g);
                
            }
        }
        
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public int getnCheckpoints(){
        return checkPoints.size();
    }

    public ArrayList<Checkpoint> getCheckPoints() {
        return checkPoints;
    }
    
    
}
