@api
Feature: user can update booking with auth token

  Scenario Outline: F05 |  User sends a put request to booking/id
    Given user sends a put request to id : <id> with firstname: <firstname>, last name <lastname>, total price <totalprice>, deposit paid <deposit>, check-in <checkin>, check-out <checkout>, additional needs <needs>
    Then Booking with the given id is updated to match fn <firstname> ln <lastname> <totalprice> <deposit> <checkin> <checkout> <needs>
    Examples:
      | id     | firstname  | lastname | totalprice | deposit | checkin      | checkout     | needs    |
      | "4211" | "Mohammed" | "Tarik"  | "500"      | "true"  | "2020-01-01" | "2020-02-02" | "Dinner" |

