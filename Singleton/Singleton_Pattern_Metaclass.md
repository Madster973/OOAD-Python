
# Singleton Pattern using Metaclass in Python

This document captures the learning and implementation of the **Singleton Design Pattern** using a **metaclass** in Python.

---

## 🧠 What is a Metaclass?

A **metaclass** is a "class of a class." It defines how a class behaves.

- Normally, when you create a class in Python, the default metaclass used is `type`.
- You can override this by specifying a custom metaclass using the `metaclass=` keyword.

---

## ✅ Goal

Ensure that only **one instance** of a class can ever exist, regardless of how many times it's instantiated.

---

## 🧩 The Metaclass Implementation

```python
class UniversalLoggerMeta(type):
    _instances = {}

    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            instance = super().__call__(*args, **kwargs)
            cls._instances[cls] = instance
        return cls._instances[cls]
```

### 🔍 Key Concepts:
- `_instances`: Dictionary to store a single instance per class
- `__call__`: This is invoked when you do `UniversalLogger()`
  - Checks if instance exists
  - If not, creates and stores it
  - Always returns the same instance

---

## 🛠 Applying the Metaclass to a Class

```python
class UniversalLogger(metaclass=UniversalLoggerMeta):

    def __init__(self):
        self._logs = []

    def log(self, message):
        self._logs.append(message)

    def get_logs(self):
        for log in self._logs:
            print(log)
```

---

## ✅ Example Usage

```python
logA = UniversalLogger()
logB = UniversalLogger()

logA.log("Log Entry from A")
logB.log("Log Entry from B")

logA.get_logs()

print(id(logA), id(logB))  # Same ID = Same Instance
```

---

## ✅ Output

```
Log Entry from A
Log Entry from B
140580134138384 140580134138384
```

---

## 💡 Why This Works

- `logA` and `logB` are different variables pointing to the **same object**.
- The `_logs` list is shared, so all logs go to the same place.
- You’ve used **metaclass magic** to globally control object creation.

---

## 🧠 Final Takeaways

- This method is reusable — any class can become a Singleton by assigning this metaclass.
- Metaclasses are a **clean and powerful** way to enforce global constraints like Singleton behavior.
