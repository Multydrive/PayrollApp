package be.heh.epm.adapter.web;

class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException(int id) {
        super("Could not find employee " + id);
    }
}
