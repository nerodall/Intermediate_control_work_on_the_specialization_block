import csv
from datetime import datetime

from Open import open_file
from View import find_note_by_id


def edit_note():
    note_id = int(input("Введите ID заметки для редактирования: "))
    notes = open_file()
    note = find_note_by_id(notes, note_id)
    if note:
        title = input("Введите новый заголовок заметки: ")
        content = input("Введите новый текст заметки: ")
        timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        note[1] = title
        note[2] = content
        note[3] = timestamp
        with open("notes.csv", "w", newline="") as file:
            writer = csv.writer(file, delimiter=";")
            writer.writerows(notes)
        print("Заметка успешно отредактирована.")
    else:
        print("Заметки с таким ID нет.")




def generate_id():
    with open("notes.csv", "r") as file:
        reader = csv.reader(file, delimiter=";")
        existing_notes = list(reader)
    if len(existing_notes) == 0:
        return 1
    last_note = existing_notes[-1]
    return int(last_note[0]) + 1


def delete_note():
    note_id = int(input("Введите ID заметки для удаления: "))
    notes = open_file()
    note = find_note_by_id(notes, note_id)
    if note:
        notes.remove(note)
        with open("notes.csv", "w", newline="") as file:
            writer = csv.writer(file, delimiter=";")
            writer.writerows(notes)
        print("Заметка успешно удалена.")
    else:
        print("Заметки с таким ID нет.")


def create_note():
    title = input("Введите заголовок заметки: ")
    content = input("Введите текст заметки: ")
    timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    note = [generate_id(), title, content, timestamp]
    return note