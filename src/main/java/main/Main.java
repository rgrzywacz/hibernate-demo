package main;

import java.util.List;
import java.util.Scanner;

import dto.WorkerDto;
import entity.Worker;
import repository.WorkerRepository;
import service.WorkerService;

public class Main {
    private static final WorkerRepository workerRepository = new WorkerRepository();
    private static final WorkerService workerService = new WorkerService(workerRepository);


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Type operation");
        System.out.println("1 - add new worker");
        System.out.println("2 - find workers by first name");
        System.out.println("3 - find workers first name and externalIds");
        int selectedOperation = in.nextInt();

        switch (selectedOperation) {
            case 1 -> {
                in.nextLine();
                System.out.println("Type user full name");
                String fullName = in.nextLine();
                System.out.println("Type user externalId");
                String externalId = in.next();

                workerService.addWorker(fullName, externalId);
            }
            case 2 -> {
                System.out.println("Type user first name");
                String firstName = in.next();
                List<Worker> workers = workerService.findWorkersByFirstName(firstName);
                workers.forEach(w -> System.out.printf(w.toString()));
            }
            case 3 -> {
                List<WorkerDto> dtos = workerService.findWorkersFirstNameAndExternalId();
                dtos.forEach(dto -> System.out.println(dto.toString()));
            }
        }

    }
}

