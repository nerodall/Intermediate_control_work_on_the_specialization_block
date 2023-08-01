import csv
from datetime import datetime


def create_note():
    title = input("Введите заголовок заметки: ")
    content = input("Введите текст заметки: ")
    timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    note = [generate_id(), title, content, timestamp]
    return note


def generate_id():
    with open("notes.csv", "r") as file:
        reader = csv.reader(file, delimiter=";")
        existing_notes = list(reader)
    if len(existing_notes) == 0:
        return 1
    last_note = existing_notes[-1]
    return int(last_note[0]) + 1


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


def read_notes():
    notes = open_file()
    if len(notes) > 1:
        print("Список заметок:")
        for note in notes:
            print(f"ID: {note[0]}, Заголовок: {note[1]}, Текст: {note[2]}, Дата: {note[3]}")
    else:
        print("Нет сохраненных заметок.")


def view_note():
    note_id = int(input("Введите ID заметки для вывода: "))
    notes = open_file()
    note = find_note_by_id(notes, note_id)
    print(f"ID: {note[0]}, Заголовок: {note[1]}, Текст: {note[2]}, Дата: {note[3]}")


def search_date():
    date_start = input("Введите начальную дату поиска в формате ГГГГ-ММ-ДД: ")
    date_final = input("Введите конечную дату поиска ГГГГ-ММ-ДД: ")
    notes = open_file()
    desired_notes =[]
    for note in notes:
        if date_start < note[3] < date_final:
            desired_notes.append(f"ID: {note[0]}, Заголовок: {note[1]}, Текст: {note[2]}, Дата: {note[3]}")
            #print(f"ID: {note[0]}, Заголовок: {note[1]}, Текст: {note[2]}, Дата: {note[3]}")
    for note in desired_notes:
        print(note)


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


def find_note_by_id(notes, note_id):
    for note in notes:
        if int(note[0]) == note_id:
            return note
    return None


def main():
    while True:
        print("\nМеню:")
        print("1. Создать заметку")
        print("2. Просмотреть список заметок")
        print("3. Редактировать заметку")
        print("4. Удалить заметку")
        print("5. Показать запись")
        print("6. Поиск по дате")
        print("0. Выход")

        choice = input("Выберите пункт меню: ")
        match (choice):

            case "1":
                note = create_note()
                save_note(note)
            case "2":
                read_notes()
            case "3":
                edit_note()
            case "4":
                delete_note()
            case "5":
                view_note()
            case "6":
                search_date()
            case "0":
                exit("Программа завершена!")


if __name__ == "__main__":
    main()
