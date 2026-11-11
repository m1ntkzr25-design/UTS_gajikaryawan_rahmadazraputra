package com.rahmad.gajikaryawan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Kelas khusus untuk perhitungan gaji (logika dipisah dari tampilan agar mudah dijelaskan).
 * Memakai BigDecimal supaya perhitungan uang akurat (tanpa error pembulatan / overflow).
 */
public class GajiCalculatorRahmad {

    // Nominal sesuai soal dosen
    public static final BigDecimal TARIF_MAKAN = new BigDecimal("10000");      // Rp10.000 per hari
    public static final BigDecimal TARIF_TRANSPORT = new BigDecimal("5000");   // Rp5.000 per hari
    public static final BigDecimal TARIF_PAJAK = new BigDecimal("0.10");       // 10%

    public final BigDecimal tunjanganMakan;
    public final BigDecimal tunjanganTransport;
    public final BigDecimal gajiKotor;
    public final BigDecimal pajak;
    public final BigDecimal gajiBersih;

    public GajiCalculatorRahmad(BigDecimal gajiPokok, BigDecimal tunjanganJabatan, long hariKerja) {
        BigDecimal hari = BigDecimal.valueOf(hariKerja);

        // 1. Tunjangan Makan = Jumlah Hari Kerja x 10.000
        tunjanganMakan = hari.multiply(TARIF_MAKAN);

        // 2. Tunjangan Transportasi = Jumlah Hari Kerja x 5.000
        tunjanganTransport = hari.multiply(TARIF_TRANSPORT);

        // 3. Gaji Kotor = Gaji Pokok + Tunjangan Jabatan + Tunjangan Makan + Tunjangan Transportasi
        gajiKotor = gajiPokok.add(tunjanganJabatan).add(tunjanganMakan).add(tunjanganTransport);

        // 4. Pajak = 10% x Gaji Kotor (dibulatkan ke rupiah terdekat)
        pajak = gajiKotor.multiply(TARIF_PAJAK).setScale(0, RoundingMode.HALF_UP);

        // 5. Gaji Bersih = Gaji Kotor - Pajak
        gajiBersih = gajiKotor.subtract(pajak);
    }

    /** Format Rupiah Indonesia, contoh: Rp1.500.000 */
    public static String formatRupiah(BigDecimal nilai) {
        DecimalFormatSymbols simbol = new DecimalFormatSymbols(Locale.US);
        simbol.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0", simbol);
        return "Rp" + df.format(nilai);
    }
}
