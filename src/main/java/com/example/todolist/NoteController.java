package com.example.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {

    private List<Note> notes = new ArrayList<>();

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", notes);
        return "note_list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") int id) {
        notes.removeIf(note -> note.getId() == id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNoteForm(@RequestParam("id") int id, Model model) {
        // Logic to retrieve note by id and pass it to the view
        return "edit_note_form";
    }

    @PostMapping("/edit")
    public String editNoteSubmit(@ModelAttribute Note note) {
        // Logic to update the note and save it
        return "redirect:/note/list";
    }

    // Additional methods for adding new notes, etc.
}
