package Chap02;

import java.time.LocalDateTime;

public class Screening {

  private Movie movie;
  private LocalDateTime whenScreened;
  private int sequence;

  public Screening(Movie movie, LocalDateTime whenScreened, int sequence) {
    this.movie = movie;
    this.whenScreened = whenScreened;
    this.sequence = sequence;
  }

  public LocalDateTime getStartTime() {
    return whenScreened;
  }

  public boolean isSequence(int sequence) {
    return this.sequence == sequence;
  }

  public Money getMovieFee(){
    return movie.getFee();
  }

  public Reservation reserve(Customer customer, int audienceCount) {
    return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
  }

  private Money calculateFee(int audienceCount) {
    return movie.calculateMovieFee(this).times(audienceCount);
  }
}
