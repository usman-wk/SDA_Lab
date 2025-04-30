package decorator.filedecorator;

import java.nio.charset.StandardCharsets;

public class UTF8Decorator extends DataSourceDecorator {

    public UTF8Decorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        // Convert to UTF-8 bytes and back to String for simulation
        byte[] utf8Bytes = data.getBytes(StandardCharsets.UTF_8);
        String utf8EncodedData = new String(utf8Bytes, StandardCharsets.UTF_8);
        super.writeData(utf8EncodedData);
    }

    @Override
    public String readData() {
        String data = super.readData();
        byte[] utf8Bytes = data.getBytes(StandardCharsets.UTF_8);
        return new String(utf8Bytes, StandardCharsets.UTF_8);
    }
}
