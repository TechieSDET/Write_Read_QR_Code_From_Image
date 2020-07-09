package base;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LearningParts {

    public static void main(String[] args) throws WriterException, IOException, NotFoundException {
        // pass the hiding information
        String qrCodeData = "prabagaran95@upi";
        //sample QR Code
        String filePath = "/Users/prabagaran/Downloads/qacode.png";
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        //Creating the QR code
        createQRCode(qrCodeData, filePath, charset, hintMap, 200, 200);
        System.out.println("Reading information from QR Code: " + readQRCode(filePath, charset, hintMap));
    }

    /**
     * Used to hide the information in QR code
     * @throws WriterException
     * @throws IOException
     */
    public static void createQRCode(String qrCodeData, String filePath, String charset, Map hintMap, int qrCodeheight, int qrCodewidth)  throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode( new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
        MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
        System.out.println("Writing information into QR Code ");
    }

    /**
     * Used to read the information in QR code
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NotFoundException
     */
    public static String readQRCode(String filePath, String charset, Map hintMap) throws FileNotFoundException, IOException, NotFoundException {
        BinaryBitmap bitMap = new BinaryBitmap(new HybridBinarizer( new BufferedImageLuminanceSource( ImageIO.read(new FileInputStream(filePath)))));
        Result qrCodeResult = new MultiFormatReader().decode(bitMap, hintMap);
        return qrCodeResult.getText();
    }

}
