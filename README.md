# How to read QR Code or Barcode from Images

<h3>Basic Understanding of QR Code or Barcode</h3>
<p> Curious on knowing how Android Apps scan the Barcodes or QR codes from the camera?

The android apps designed to scan 1D & 2D barcodes on a high level convert the data the camera into image bytes to the below library, which in-turn return the data embedded within the bar codes.

Reading Barcodes / QR codes from images seems to be difficult & using the below open source libraries(ZXing - Zebra Crossing) provided by Google will make it simple for any application to include this functionality.

In real Time, we are using QR code in daily use. Some of famous application are paytm, phonepe, amazon pay, etc.,</p>

<h5> How to valiate QR Code or Barcode from image in android/iOS app.</h5>
Below code are example for unit testing.</h5>

 <h3>Add maven repository to pom.xml file.</h4>
<textarea>
		<!-- https://mvnrepository.com/artifact/com.google.zxing/core -->
		<dependency3
			<groupId>com.google.zxing</groupId>
			<artifactId>core</artifactId>
			<version>3.4.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.google.zxing/javase -->
		<dependency>
			<groupId>com.google.zxing</groupId>
			<artifactId>javase</artifactId>
			<version>3.4.0</version>
		</dependency>

</textarea>

  
