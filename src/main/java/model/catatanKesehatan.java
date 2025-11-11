/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo
 */
import java.time.LocalDate;

public class catatanKesehatan {
    private LocalDate tanggal;
    private String namaMenu;
    private int kalori;
    private String waktuMakan;

    /**
     *
     * @param tanggal
     * @param namaMenu
     * @param kalori
     * @param waktuMakan
     */
    public catatanKesehatan(LocalDate tanggal, String namaMenu, int kalori, String waktuMakan) {
        this.tanggal = tanggal;
        this.namaMenu = namaMenu;
        this.kalori = kalori;
        this.waktuMakan = waktuMakan;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public int getKalori() {
        return kalori;
    }

    public void setKalori(int kalori) {
        this.kalori = kalori;
    }

    public String getWaktuMakan() {
        return waktuMakan;
    }

    public void setWaktuMakan(String waktuMakan) {
        this.waktuMakan = waktuMakan;
    }

    public String getKaloriDenganSatuan() {
        return kalori + " kkal";
    }
}
