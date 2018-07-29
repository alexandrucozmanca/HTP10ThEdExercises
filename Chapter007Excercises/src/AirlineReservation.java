import javax.swing.JOptionPane;

public class AirlineReservation
{

	public static void main(String[] args)
	{
		boolean[] economy = new boolean[5]; // economy class seats - by default all are unoccupied
		boolean[] firstClass = new boolean[5]; // first class seats  - by default all are unoccupied

		boolean keepBooking = true; // sentinel variable for more bookings

		do
		{


			int flightClass = 0, // flight class variable
					seat; // seat variable

			// query user for class selection
			Object[] options = {"Economy","First Class"};
			flightClass = JOptionPane.showOptionDialog(null,
					"Please select flight class",
					"Flight Booking",
					JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);

			// for economy class
			if(flightClass == 0)
				{
				seat = findEmptySeat(economy); // look for first free seat
				if (seat < economy.length) // if seat found
				{
					economy[seat] = true; // occupy seat
					printPass(seat,"Economy"); // print pass
				}
				else // if economy class unavailable
				{
					// re-query user if would like to book on alternative First Class
					options[0] = "Yes";
					options[1] = "No";
					flightClass = JOptionPane.showOptionDialog(null,
					"No more options available in Economy, would you like to book on First Class?",
					"Warning!",
					JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);

					if(flightClass == 0) // if yes
					{
						seat = findEmptySeat(firstClass); // find first empty seat
						if (seat < firstClass.length) // if yes
						{
							firstClass[seat] = true; // occupy seat
							printPass(seat,"First Class"); // print pass
						}
						else // if no empty seats
						{
							// inform user no seats available whatsoever
							JOptionPane.showMessageDialog(null,
									"We are sorry but the plane is fully booked.\n"
									+ "Next flight leaves in 3 hours.");
							System.exit(0); // stop application
						}


					}
					else // if user will not book alternative
					{
						JOptionPane.showMessageDialog(null, "Next flight leaves in 3 hours.\n"
								+ "Good bye");
						System.exit(0);
					}
				}

				}
			else // for first class
			{
				seat = findEmptySeat(firstClass); //look for first available seat
				if (seat <firstClass.length) // if found
				{
					firstClass[seat] = true; // occupy seat
					printPass(seat,"First Class"); // print pass
				}
				else // if no available seat
				{
					// new query for alternative booking on economy
					options[0] = "Yes";
					options[1] = "No";
					flightClass = JOptionPane.showOptionDialog(null,
					"No more options available in FirstClass, would you like to book on Economy?",
					"Warning",
					JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);

					if(flightClass == 0) // if yes
					{
						seat = findEmptySeat(economy); // find first available seat
						if (seat < economy.length) // if found
						{
							economy[seat] = true; // occupy seat
							printPass(seat,"Economy"); // print pass
						}

						else // if no empty seats
						{
							// inform user no seats available whatsoever
							JOptionPane.showMessageDialog(null,
									"We are sorry but the plane is fully booked\n"
									+ "Next flight leaves in 3 hours.");
							System.exit(0);
						}
					}
				}

			}
				// ask user if additional bookings
				options[0] = "Yes";
				options[1] = "No";

				int input = JOptionPane.showOptionDialog(null,
						"Would you like to book another seat?",
						"Flight Booking",
						JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);

				if (input == 1) // if not
				{
					keepBooking = false; // complete sentinel condition
					JOptionPane.showMessageDialog(null, "Good bye");
				}



		}	while (keepBooking == true);




	}// end main


	// method to find first available seat in a seat array
	public static int findEmptySeat(boolean [] seats)
	{
		int seat = 0;

		while (seat < seats.length && seats[seat] == true)
		{
			seat++;
		}
		return seat;
	}

	// method to print boarding pass
	public static void printPass(int seat, String flightClass)
	{
		JOptionPane.showMessageDialog(null, "Your have seat no. " + (seat + 1) + " in " + flightClass + ".");
	}

}
