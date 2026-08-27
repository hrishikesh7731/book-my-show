package com.bms.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booked-seats")
public class BookedSeat extends GlobalRecord{
    @ManyToOne
    private MovieShow movieShow;
    private String seatId;
}
