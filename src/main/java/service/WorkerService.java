package service;

import java.util.ArrayList;
import java.util.List;

import dto.WorkerDto;
import entity.Worker;
import repository.WorkerRepository;

public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public void addWorker(String fullName, String externalId) {
        String[] fullNameParts = fullName.split(" ");
        if ((fullNameParts.length > 1 && fullNameParts.length <= 3) && externalId.length() > 3) {
            Worker worker = new Worker(fullName, externalId);
            workerRepository.insert(worker);
        }
    }

    public List<Worker> findWorkersByFirstName(String firstName) {
        List<Worker> workers = new ArrayList<>();
        if (firstName.length() >= 3) {
            workers = workerRepository.findWorkersByFirstName(firstName);
        }
        return workers;
    }

    public List<WorkerDto> findWorkersFirstNameAndExternalId() {
        List<Object[]> workersFirstNameAndExternalId = workerRepository.findWorkersFirstNameAndExternalId();
        List<WorkerDto> workerDtos = workersFirstNameAndExternalId.stream().map(o -> new WorkerDto((String) o[0], (String) o[1])).toList();
        return workerDtos;
    }
}
