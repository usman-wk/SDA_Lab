package decorator.filedecorator;

public interface DataSource {
    void writeData(String data);

    String readData();
}