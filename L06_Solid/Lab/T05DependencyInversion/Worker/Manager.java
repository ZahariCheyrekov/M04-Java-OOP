package M04_JavaOOP.L06_Solid.Lab.T05DependencyInversion.Worker;

public class Manager {

    public Manager() {
        Worker worker = new Worker();
        worker.work();
    }
}
