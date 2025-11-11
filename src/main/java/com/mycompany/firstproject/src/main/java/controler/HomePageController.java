/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controler;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.catatanKesehatan;
import java.time.LocalDate;

public class HomePageController {
    ObservableList<String> WaktuMakan = FXCollections.observableArrayList("Pagi","Siang","Malam");

    @FXML private DatePicker datePickerTanggal;
    @FXML private TextField tfNamaMenu;
    @FXML private TextField tfKalori;
    @FXML private ChoiceBox cbWaktuMakan;

    @FXML private Button btnAdd;
    @FXML private Button btnEdit;
    @FXML private Button btnDelete;
    @FXML private Button btnReset;

    @FXML private TableView<catatanKesehatan> tableKesehatan;
    @FXML private TableColumn<catatanKesehatan, LocalDate> colTanggal;
    @FXML private TableColumn<catatanKesehatan, String> colNamaMenu;
    @FXML private TableColumn<catatanKesehatan, String> colKalori;
    @FXML private TableColumn<catatanKesehatan, String> colWaktuMakan;

    private ObservableList<catatanKesehatan> dataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cbWaktuMakan.setItems(FXCollections.observableArrayList("Pagi", "Siang", "Malam"));

        colTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        colNamaMenu.setCellValueFactory(new PropertyValueFactory<>("namaMenu"));
        colKalori.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getKaloriDenganSatuan()));
        colWaktuMakan.setCellValueFactory(new PropertyValueFactory<>("waktuMakan"));

        tableKesehatan.setItems(dataList);
    }

    @FXML
    private void handleAdd() {
        LocalDate tanggal = datePickerTanggal.getValue();
        String namaMenu = tfNamaMenu.getText();
        String waktuMakan = (String) cbWaktuMakan.getValue();

        if (tanggal == null || namaMenu.isEmpty() || tfKalori.getText().isEmpty() || waktuMakan == null) {
            showAlert("Lengkapi semua kolom terlebih dahulu!");
            return;
        }

        try {
            int kalori = Integer.parseInt(tfKalori.getText());
            dataList.add(new catatanKesehatan(tanggal, namaMenu, kalori, waktuMakan));
            clearForm();
        } catch (NumberFormatException e) {
            showAlert("Kalori harus berupa angka!");
        }
    }

    @FXML
    private void handleEdit() {
       catatanKesehatan selected = tableKesehatan.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Pilih data yang ingin diedit!");
            return;
        }

        try {
            selected.setTanggal(datePickerTanggal.getValue());
            selected.setNamaMenu(tfNamaMenu.getText());
            selected.setKalori(Integer.parseInt(tfKalori.getText()));
            selected.setWaktuMakan((String) cbWaktuMakan.getValue());
            tableKesehatan.refresh();
            clearForm();
        } catch (NumberFormatException e) {
            showAlert("Kalori harus berupa angka!");
        }
    }

    @FXML
    private void handleDelete() {
        ObservableList<catatanKesehatan> selectedItems = tableKesehatan.getSelectionModel().getSelectedItems();
        if (selectedItems.isEmpty()) {
            showAlert("Pilih data yang ingin dihapus!");
            return;
        }
        dataList.removeAll(selectedItems);
    }

    @FXML
    private void handleReset() {
        dataList.clear();
        clearForm();
    }

    private void clearForm() {
        datePickerTanggal.setValue(null);
        tfNamaMenu.clear();
        tfKalori.clear();
        cbWaktuMakan.setValue(null);
    }

    private void showAlert(String pesan) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informasi");
        alert.setHeaderText(null);
        alert.setContentText(pesan);
        alert.showAndWait();
    }
}
