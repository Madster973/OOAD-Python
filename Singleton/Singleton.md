
# Singleton Pattern in Python — Learning Journey

This document captures the step-by-step exploration and understanding of the **Singleton Design Pattern** in Python.

---

## 🧩 Problem Statement

You began with a simple task:

> Create a `Logger` class such that multiple instances of the class share the same log.

Initial implementation:
```python
class UniversalLogger:
    def __init__(self):
        self._logs = []

    def log(self, message):
        self._logs.append(message)

    def get_logs(self):
        for log in self._logs:
            print(log)
```

**Observation**:
- Each instance (`logA`, `logB`) had its own `_logs` list.
- Logs were not shared.

---

## ✅ Step 1: Shared Data via Class Variable

Modified `_logs` to be a class variable:

```python
class UniversalLogger:
    _logs = []

    def log(self, message):
        self._logs.append(message)

    def get_logs(self):
        for log in self._logs:
            print(log)
```

**Result**:
- Logs are shared across instances.
- But multiple instances still exist.

---

## ❓ Why Is That a Problem?

1. **Confusion**: Accidental creation of instance variables can shadow the class variable.
2. **Resource Management**: Some resources (e.g., DB connections, file writers) should only have one instance.
3. **Identity Issues**: `logA is not logB`, which breaks the Singleton guarantee.

---

## 🧠 Discovery: `__new__` Method

You learned that:
- `__new__` is called **before** `__init__`
- It is used to **control instance creation**
- `super().__new__(cls)` is the correct way to delegate object creation to Python

---

## ✅ Final Singleton Implementation

```python
class UniversalLogger:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
        return cls._instance

    def __init__(self):
        self._logs = []

    def log(self, message):
        self._logs.append(message)

    def get_logs(self):
        for log in self._logs:
            print(log)
```

### Usage:
```python
logA = UniversalLogger()
logB = UniversalLogger()

logA.log("Log Entry from A")
logB.log("Log Entry from B")

logA.get_logs()
print(id(logA), id(logB))  # Same object!
```

---

## 🧠 Summary of Key Learnings

- **Class variables** are shared across instances.
- Use `__new__` to **control and restrict** instance creation.
- Use `super().__new__(cls)` to create the object from the base class.
- Singleton ensures **one and only one** instance is ever created.
- Useful for **logging, configuration, caching, DB connections**, etc.

---
