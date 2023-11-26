# snap-ocr

<h2>Overview</h2>
<p>This Java Swing application is designed to convert image text into a text file using the powerful Tesseract OCR engine. Whether you have scanned documents, images with embedded text, or any other image containing textual information, this application provides a simple and efficient way to extract and save the text content.</p>

<h2>Features</h2>

  <ul>
    <li><strong>User-Friendly Interface:</strong> The application utilizes Java Swing for a clean and intuitive user interface, making it easy for users to navigate and use the tool.</li>
    <li><strong>Tesseract OCR Engine:</strong> Leveraging the Tesseract OCR engine, the application ensures accurate and reliable extraction of text from images.</li>
    <li><strong>Text File Output:</strong> The extracted text is saved into a text file, allowing users to easily access and edit the recognized text.</li>
  </ul>

  <h2>Getting Started</h2>

  <ol>
    <li><strong>Clone the Repository:</strong></li>
  </ol>

  <pre><code>git clone https://github.com/Raka-01/snap-ocr.git
cd snap-ocr</code></pre>

  <ol start="2">
    <li><strong>Build and Run:</strong></li>
  </ol>

  <ul>
    <li>Open the project in your preferred Java IDE.</li>
    <li>Build and run the <code>snap-ocr.java</code> file to launch the application.</li>
  </ul>

  <h2>Download Tesseract OCR Engine</h2>

  <p>Before using the application, we need to download and install the Tesseract OCR engine. <br>
  Here is the direct link to download <a href="https://github.com/UB-Mannheim/tesseract/wiki">Tesseract installer for Windows</a>. Users other than Windows can download it from <a href="https://tesseract-ocr.github.io/tessdoc/Installation.html">Tesseract download page</a>.
  </p>

  <h2>Add tess4j Library</h2>

<p>After downloading the Tesseract OCR Engine, we need to add a tess4j library to your class path. A tess4j library is a Java wrapper that we need to make the Tesseract functional.<br>
Please note that tess4j may need some supporting jars in order to run the application successfully. <br>Here is the direct link to <a href="https://jar-download.com/artifact-search/tess4j">download tess4j JAR file with all dependencies</a>.
</p>

  <h2>Dependencies</h2>

  <ul>
    <li><a href="https://github.com/tesseract-ocr/tesseract">Tesseract OCR</a>: The OCR engine used for text extraction.</li>
    <li><a href="https://docs.oracle.com/javase/8/docs/technotes/guides/swing/">Java Swing</a>: The graphical user interface toolkit for the Java platform.</li>
  </ul>

  <h2>Contributing</h2>

  <p>Contributions are welcome! If you have suggestions, feature requests, or find any issues, please open an <a href="https://github.com/your-username/image-to-text-converter/issues">issue</a> or submit a <a href="https://github.com/Raka-01/snap-ocr/pulls">pull request</a>.</p>
