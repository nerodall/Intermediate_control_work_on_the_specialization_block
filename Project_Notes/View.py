import Open


def read_notes():
    notes = Open.open_file()
    if len(notes) > 1:
        print("Список заметок:")
        for note in notes:
            print(f"ID: {note[0]}, Заголовок: {note[1]}, Текст: {note[2]}, Дата: {note[3]}")
    else:
        print("Нет сохраненных заметок.")


def view_note():
    note_id = int(input("Введите ID заметки для вывода: "))
    notes = Open.open_file()
    note = find_note_by_id(notes, note_id)
    print(f"ID: {note[0]}, Заголовок: {note[1]}, Текст: {note[2]}, Дата: {note[3]}")

def find_note_by_id(notes, note_id):
    for note in notes:
        if int(note[0]) == note_id:
            return note
    return None


def search_date():
    date_start = input("Введите начальную дату поиска в формате ГГГГ-ММ-ДД: ")
    date_final = input("Введите конечную дату поиска ГГГГ-ММ-ДД: ")
    notes = Open.open_file()
    desired_notes =[]
    for note in notes:
        if date_start < note[3] < date_final:
            desired_notes.append(f"ID: {note[0]}, Заголовок: {note[1]}, Текст: {note[2]}, Дата: {note[3]}")
            #print(f"ID: {note[0]}, Заголовок: {note[1]}, Текст: {note[2]}, Дата: {note[3]}")
    for note in desired_notes:
        print(note)