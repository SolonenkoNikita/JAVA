package ru.npsolonenko;

import java.util.List;

public class DIP {

    interface Repository {
        void insertAll(List<Object> list);
        List<Object> getAll();
    }

    static class RepositoryImpl implements Repository {

        @Override
        public void insertAll(List<Object> list) {

        }

        @Override
        public List<Object> getAll() {
            return List.of();
        }
    }

    static class InsertAllObjectsUseCase {
        private final Repository repository;

        public InsertAllObjectsUseCase(Repository repository) {
            this.repository = repository;
        }

        void execute(List<Object> list) {
            repository.insertAll(list);
        }
    }

    public static void main(String[] args) {
        Repository repository = new RepositoryImpl();

        new InsertAllObjectsUseCase(repository).execute(List.of());
    }

}
