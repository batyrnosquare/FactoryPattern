package factory_design_pattern;

//abstract class Computer
public abstract class Computer {

    //abstract methods to get info about ram, hdd, and cpu.
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    // overridden method provides a string of a Computer object.
    @Override
    public String toString() {
        //returns a string with info about the computer
        return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
    }
}

// subclass named PC that extends Computer abstract class.
class PC extends Computer {

    // variables to store information about the PC.
    private String ram;
    private String hdd;
    private String cpu;

    // constructor for the PC class that takes parameters to get hardware
    public PC(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    // overridden methods provide values for RAM, HDD, and CPU.
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}



// subclass named server that also extends Computer abstract class.
class Server extends Computer {

    // variables to store information about the Server.
    private String ram;
    private String hdd;
    private String cpu;

    // constructor for the server class that takes parameters to initialize RAM, HDD, and CPU.
    public Server(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    // overridden methods to provide specific values for RAM, HDD, and CPU.
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}




// factory class ComputerFactory
class ComputerFactory {

    // static factory method to create and return a Computer object
    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if ("PC".equalsIgnoreCase(type)) {
            return new PC(ram, hdd, cpu); //return an instance of the PC class
        } else if ("Server".equalsIgnoreCase(type)) {
            return new Server(ram, hdd, cpu); //return an instance of the server class
        }
        return null; // if the type is invalid, return null.
    }
}


// main class to test the Factory design pattern.
class TestFactory {

    public static void main(String[] args) {
        // create a pC instance using the ComputerFactory with specifications.
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");

        // create a server instance using the ComputerFactory with specifications.
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");

        // output
        System.out.println("Factory PC Config::" + pc);
        System.out.println("Factory Server Config::" + server);
    }
}
