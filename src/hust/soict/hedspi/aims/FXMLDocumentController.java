package hust.soict.hedspi.aims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.shape.Circle;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.PlayerException;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Admin
 */
public class FXMLDocumentController implements Initializable {
    private int countFree;
    
    @FXML private TableView<DigitalVideoDisc> tableDVD;
    @FXML private TableColumn<DigitalVideoDisc, Integer> dvdId;
    @FXML private TableColumn<DigitalVideoDisc, String> dvdTitle;
    @FXML private TableColumn<DigitalVideoDisc, String> dvdCategory;
    @FXML private TableColumn<DigitalVideoDisc, String> dvdDirectory;
    @FXML private TableColumn<DigitalVideoDisc, Float> dvdCost;
    @FXML private TableColumn<DigitalVideoDisc, Integer> dvdLength;
    
    @FXML private TableView<Book> tableBook;
    @FXML private TableColumn<Book, Integer> bookId;
    @FXML private TableColumn<Book, String> bookTitle;
    @FXML private TableColumn<Book, String> bookCategory;
    @FXML private TableColumn<Book, Float> bookCost;
    @FXML private TableColumn<Book, ArrayList<String>> bookAuthors;
    
    @FXML private TableView<CompactDisc> tableCD;
    @FXML private TableColumn<CompactDisc, Integer> cdId;
    @FXML private TableColumn<CompactDisc, String> cdTitle;
    @FXML private TableColumn<CompactDisc, String> cdCategory;
    @FXML private TableColumn<CompactDisc, String> cdArtist;
    @FXML private TableColumn<CompactDisc, Float> cdCost;
    @FXML private TableColumn<CompactDisc, Integer> cdLength;
    
    @FXML private static Order order = null;
    
    @FXML private TableView<Media> tableOrder;
    @FXML private TableColumn<Media, Integer> orderId;
    @FXML private TableColumn<Media, String> orderTitle;
    @FXML private TableColumn<Media, String> orderCategory;
    @FXML private TableColumn<Media, Float> orderCost;
    
    @FXML private TableView<Track> tableTrack;
    @FXML private TableColumn<Track, String> trackTitle;
    @FXML private TableColumn<Track, Integer> trackLength;
    
    @FXML private Button addDVD;
    @FXML private Button addBook;
    @FXML private Button addCD;
    @FXML private Button deleteFromOrder;
    @FXML private Button reset;
    @FXML private Button createOrder;
    @FXML private Button luckyItem;
    @FXML private Button playCD;
    @FXML private Button playDVD;
    //@FXML
    // Method here
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        trackTitle.setCellValueFactory(new PropertyValueFactory<Track, String>("title"));
        trackLength.setCellValueFactory(new PropertyValueFactory<Track, Integer>("length"));
        
        dvdId.setCellValueFactory(new PropertyValueFactory<DigitalVideoDisc, Integer>("id"));
        dvdTitle.setCellValueFactory(new PropertyValueFactory<DigitalVideoDisc, String>("title"));
        dvdCategory.setCellValueFactory(new PropertyValueFactory<DigitalVideoDisc, String>("category"));
        dvdDirectory.setCellValueFactory(new PropertyValueFactory<DigitalVideoDisc, String>("director"));
        dvdCost.setCellValueFactory(new PropertyValueFactory<DigitalVideoDisc, Float>("cost"));
        dvdLength.setCellValueFactory(new PropertyValueFactory<DigitalVideoDisc, Integer>("length"));
        tableDVD.setItems(getDVD());
        
        bookId.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        bookTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        bookCategory.setCellValueFactory(new PropertyValueFactory<Book, String>("category"));
        bookCost.setCellValueFactory(new PropertyValueFactory<Book, Float>("cost"));
        bookAuthors.setCellValueFactory(new PropertyValueFactory<Book, ArrayList<String>>("authors"));
        tableBook.setItems(getBook());
        
        cdId.setCellValueFactory(new PropertyValueFactory<CompactDisc, Integer>("id"));
        cdTitle.setCellValueFactory(new PropertyValueFactory<CompactDisc, String>("title"));
        cdCategory.setCellValueFactory(new PropertyValueFactory<CompactDisc, String>("category"));
        cdArtist.setCellValueFactory(new PropertyValueFactory<CompactDisc, String>("artist"));
        cdCost.setCellValueFactory(new PropertyValueFactory<CompactDisc, Float>("cost"));
        cdLength.setCellValueFactory(new PropertyValueFactory<CompactDisc, Integer>("length"));
        tableCD.setItems(getCD());
        
        orderId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        orderTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        orderCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        orderCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tableOrder.setItems(getOrder());
    }    
    
    public ObservableList<DigitalVideoDisc> getDVD(){
        ObservableList<DigitalVideoDisc> dvd = FXCollections.observableArrayList();
        dvd.add(new DigitalVideoDisc(1000, "Miyazaki", 0, "Totoro", "Anime", 250.0f));
        dvd.add(new DigitalVideoDisc(430, "Suzuki", 1, "Mononoke", "Anime", 130.0f));
        dvd.add(new DigitalVideoDisc(1235, "John", 2, "Dead or Alive", "Action", 120.0f));
        dvd.add(new DigitalVideoDisc(255, "Mike", 3, "Tom and Jerry", "Animation", 100.0f));
        dvd.add(new DigitalVideoDisc(400, "Van Minh", 4, "Gia dinh", "Film", 90.0f));
        dvd.add(new DigitalVideoDisc(560, "Jack", 5, "Final week", "Action", 550.0f));
        dvd.add(new DigitalVideoDisc(900, "Minh Quan", 6, "Hoc C", "Learn", 420.0f));
        dvd.add(new DigitalVideoDisc(390, "Tuan Kiet", 7, "C++ tot hon C", "Learn", 1000.0f));
        dvd.add(new DigitalVideoDisc(900, "Johnson", 8, "Do and Do", "Action", 80.0f));
        dvd.add(new DigitalVideoDisc(390, "Tuan Kiet", 9, "Winning", "Learn", 800.0f));
        return dvd;
    }
    
    public ObservableList<Book> getBook(){
        ObservableList<Book> book = FXCollections.observableArrayList();
        Book data = new Book(10, "Learn C", "Learn", 1000.0f);
        List<String> authors = new ArrayList<>();
        authors.add("Jonhny");
        data.setAuthors(authors);
        book.add(data);
        
        data = new Book(11, "How to get taller", "Biological", 2000.0f);
        authors = new ArrayList<>();
        authors.add("Tuan Kiet");
        authors.add("DeepFry");
        data.setAuthors(authors);
        book.add(data);
        return book;
    }
    
    public ObservableList<CompactDisc> getCD() {
        ObservableList<CompactDisc> CD = FXCollections.observableArrayList();
        CompactDisc cd = new CompactDisc("Quang Le", 500, "Quang Le", 12, "Dem He", "Bolero", 240.0f);
        cd.addTrack(new Track("Dem he", 500));
        CD.add(cd);
        
        cd = new CompactDisc("Duy Khanh", 500, "Paris by Night", 13, "Cam on", "Bolero", 350.0f);
        cd.addTrack(new Track("Cam on", 500));
        CD.add(cd);
        
        cd = new CompactDisc("Manh Quynh", 500, "Paris by Night", 14, "Vong nhan cuoi", "Bolero", 100.0f);
        cd.addTrack(new Track("Vong nhan cuoi", 500));
        CD.add(cd);
        
        cd = new CompactDisc("Quang Le", 500, "Quang Le", 15, "No", "Bolero", 190.0f);
        cd.addTrack(new Track("No", 500));
        CD.add(cd);
        
        cd = new CompactDisc("Manh Quynh", 500, "Manh Quynh", 16, "Me toi", "Bolero", 400.0f);
        cd.addTrack(new Track("Me toi", 500));
        CD.add(cd);
        
        cd = new CompactDisc("Truong Vu", 500, "Truong Vu", 17, "No va toi", "Bolero", 200.0f);
        cd.addTrack(new Track("No va toi", 500));
        CD.add(cd);
        return CD;
    }
    
    public ObservableList<Media> getOrder(){
        ObservableList<Media> md = FXCollections.observableArrayList();
        if(order != null){
            if(order.getItemOrdered() != null){
                order.getItemOrdered().forEach((Items) -> {
                    md.add(Items);
                });
            }
        }
        return md;   
    }
    
    @FXML public void createOrder(){
        try {
            order = new Order();
            countFree = 0;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Thông báo");
            alert.setContentText("Tạo Order mới thành công");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Thông báo");
            alert.setContentText("Tạo Order mới thất bại");
            alert.showAndWait();
        }
    }
    
    @FXML public DigitalVideoDisc getDataDVD(){
        DigitalVideoDisc dvd = tableDVD.getSelectionModel().getSelectedItem();
        return dvd;
    }
    
    @FXML public Book getDataBook(){
        Book book = tableBook.getSelectionModel().getSelectedItem();
        return book;
    }
    
    @FXML public CompactDisc getDataCD(){
        CompactDisc cd = tableCD.getSelectionModel().getSelectedItem();
        return cd;
    }
    
    @FXML public Media getDataOrder(){
        Media md = tableOrder.getSelectionModel().getSelectedItem();
        return md;
    }
    
    @FXML public void addDVD() throws PlayerException{
        DigitalVideoDisc dvd = getDataDVD();
        if(order != null){
            if(dvd != null){
                order.addMedia(dvd);
                tableOrder.setItems(getOrder());
            }else{
                throw new PlayerException("YOU MUST CHOOSE ONE!");
            }    
        }else{
            throw new PlayerException("ORDER IS NOT CREATED!");
        }
    }
    
    @FXML public void addBook() throws PlayerException{
        Book book = getDataBook();
        if(order != null){
            if(book != null){
                order.addMedia(book);
                tableOrder.setItems(getOrder());
            }else{
                throw new PlayerException("YOU MUST CHOOSE ONE!");
            }    
        }else{
            throw new PlayerException("ORDER IS NOT CREATED!");
        }
    }
    
    @FXML public void addCD() throws PlayerException{
        CompactDisc cd = getDataCD();
        if(order != null){
            if(cd != null){
                order.addMedia(cd);
                tableOrder.setItems(getOrder());
            }else{
                throw new PlayerException("YOU MUST CHOOSE ONE!");
            }    
        }else{
            throw new PlayerException("ORDER IS NOT CREATED!");
        }
    }
    
    @FXML public void deleteFromOrder() throws PlayerException{
        if(order != null){
            Media md = getDataOrder();
            if(md != null){
                order.removeMedia(md);
                tableOrder.setItems(getOrder());
            }else{
                throw new PlayerException("YOU STILL NOT CHOOSE THE ITEM");
            }
        }else{
            throw new PlayerException("ORDER IS NOT CREATED!");
        }
    }
    
    @FXML public void getLuckyItem() throws PlayerException{
        if(order != null){
            if(countFree == 0){
                if(order.totalCost() > 1000.0f && Order.getNbOrdered() >= 5){
                    order.getALuckyItem();
                    countFree = 1;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Thông báo");
                    alert.setContentText("Nhận thành công");
                    alert.showAndWait();
                    tableOrder.setItems(getOrder());
                }else{
                    throw new PlayerException("STILL UNQUALIFIED");
                }                
            }else{
                throw new PlayerException("ONLY ONE PRODUCT IS GIVEN");
            }    
        }else{
            throw new PlayerException("ORDER IS NOT CREATED");
        }
    }
    
    @FXML public void playCD() throws PlayerException{
        CompactDisc cd = getDataCD();
        int check = 0;
        if(cd != null){
            ObservableList<Track> track = FXCollections.observableArrayList();
            if(cd.getTracks() != null){
                if(cd.getLength() > 0){
                    cd.getTracks().forEach((Item) -> {
                        if(Item.getLength() > 0){
                            track.add(Item);
                        }
                    });
                    tableTrack.setItems(track);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Track của CD được phát tại Play Tracks");
                    alert.showAndWait();
                }else{
                    throw new PlayerException("CD LENGTH IS NON-POSITIVE!");
                }
                
            }else{
                throw new PlayerException("TRACK IN CD IS NULL!");
            }
        }else{
            throw new PlayerException("YOU NEED TO CHOOSE ONE CD!");
        }
    }
    
    @FXML public void playDVD() throws PlayerException{
        DigitalVideoDisc dvd = getDataDVD();
        if(dvd != null){
            if(dvd.getLength() > 0){
                String title = "Title: " + dvd.getTitle();
                String length = "Length: " + dvd.getLength();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("DVD đang chạy");
                alert.setContentText(title+"\n"+length);
                alert.showAndWait();
            }else{
                throw new PlayerException("DVD LENGTH IS NON-POSITIVE");
            }
            
        }else{
            throw new PlayerException("YOU NEED TO CHOOSE ONE DVD!");
        }
    }
    
    @FXML public void resetPlay(){
        tableTrack.getItems().clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Reset bảng thành công");
        alert.showAndWait();
    }
}
