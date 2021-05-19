package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.entities.Holiday;
import com.stefanini.appointmentapp.service.HolidayService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("api/holidays")
public class HolidayController {

    HolidayService holidayService;

    /**
     * Constructs and initiates HolidayController object with instance of HolidayService.
     *
     * @param holidayService Instance of HolidayService
     */

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    Holiday create(@RequestBody Holiday holiday) {
        return holidayService.create(holiday);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    Holiday update(@RequestBody Holiday holiday) {
        return holidayService.update(holiday);
    }

    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody Holiday holiday) {
        holidayService.delete(holiday);
    }

    @GetMapping("/{id}")
    Holiday findById(@PathVariable Long id) {
        return holidayService.findById(id);
    }

    @GetMapping("")
    Set<Holiday> findAll() {
        return holidayService.findAll();
    }
}
