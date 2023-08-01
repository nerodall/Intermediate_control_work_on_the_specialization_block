import csv


def open_file():
    with open("notes.csv", "r") as file:
        reader = csv.reader(file, delimiter=";")
        notes = list(reader)
    return notes



def save_note(note):
    with open("notes.csv", "a", newline="") as file:
        writer = csv.writer(file, delimiter=";")
        writer.writerow(note)
    print("Заметка сохранена.")
