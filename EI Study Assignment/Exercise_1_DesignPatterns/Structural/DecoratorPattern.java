interface DataSource {
    void writeData(String data);
}

class FileDataSource implements DataSource {
    @Override
    public void writeData(String data) {
        System.out.println("Writing data: " + data);
    }
}

class DataSourceDecorator implements DataSource {
    protected DataSource wrappee;
    
    DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }
}

class EncryptionDecorator extends DataSourceDecorator {
    EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        data = "Encrypted: " + data;
        super.writeData(data);
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        DataSource source = new FileDataSource();
        DataSource encryptedSource = new EncryptionDecorator(source);
        encryptedSource.writeData("Secret message");
    }
}
