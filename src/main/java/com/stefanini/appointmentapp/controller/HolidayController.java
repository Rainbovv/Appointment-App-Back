package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.entities.Holiday;
import com.stefanini.appointmentapp.service.HolidayService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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

    @Loggable
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    Holiday create(@RequestBody Holiday holiday) {
        return holidayService.create(holiday);
    }

    @Loggable
    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    Holiday update(@RequestBody Holiday holiday) {
        return holidayService.update(holiday);
    }

    @Loggable
    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody Holiday holiday) {
        holidayService.delete(holiday);
    }

    @Loggable
    @GetMapping("/{id}")
    Holiday findById(@PathVariable Long id) {
        return holidayService.findById(id);
    }

    @Loggable
    @GetMapping("")
    List<Holiday> findAll() {
        return holidayService.findAll();
    }
}
