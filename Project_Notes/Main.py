import csv
from datetime import datetime

import Open
from Edit import create_note, edit_note, delete_note
from View import read_notes, view_note, search_date


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
                Open.save_note(note)
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
