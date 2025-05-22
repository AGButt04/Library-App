import javax.swing.JOptionPane;

public class LibraryInput implements InputHandler {
	
	public void handleInput(String input) {
		
		char choice = input.toLowerCase().charAt(0);
		switch (choice) {
		case 's':
			LibraryApp.DisplaySmenu();
			break;
		case 'l':
			LibraryApp.DisplayLmenu();
			break;
		default:
			LibraryApp.print("Invalid Input.");
		}
	}
	
	public void runLmenu(String ch) {
		char cha = ' ';
		cha = ch.toLowerCase().charAt(0);
		switch (cha) {
			case 'i':
				LibraryApp.registerLibrarian();
				break;
			case 'f':
				String id2 = JOptionPane.showInputDialog(null, "Enter your librarian ID: ");
				boolean check = false;
				for (User u : LibraryApp.users) {
					if (u.getID().equals(id2))
						check = true;
					else
						check = false;
				}
				if (check) {
					for (User s : LibraryApp.users) {
						if (s instanceof Student) {
							Student stu = (Student) s;
							LibraryApp.print(stu.getName() + " owes $" + stu.getFine());
						}
					}
				} else {
					LibraryApp.print("You are not in our system.");
				}
				break;
			case 'a':
				String id = JOptionPane.showInputDialog(null, "Enter your Librarian ID: ");
				for (User u : LibraryApp.users) {
					if (u instanceof Librarian && u.getID().equals(id))  {
						Librarian lib = (Librarian) u;
						lib.addBook();
					}
				}
				break;
			case 'r':
				String id1 = JOptionPane.showInputDialog(null,"Enter your Librarian ID: ");
				for (User u : LibraryApp.users) {
					if (u instanceof Librarian && u.getID().equals(id1))  {
						Librarian lib = (Librarian) u;
						String n = JOptionPane.showInputDialog(null, "Enter the title of the book you want to remove: ");
						lib.removeBook(n);
					}
				}
				break;
			case 'd':
				for (Book b : LibraryApp.books) {
					LibraryApp.print(b);
				}
				break;
			case 'c':
				break;
			case 'o':
				String ch1 = JOptionPane.showInputDialog(null, "Enter the name of the book you are looking for: ");
				LibraryApp.searchBook(ch1);
				break;
			case 'n':
				for (User s : LibraryApp.users) {
					if (s instanceof Student) 
						LibraryApp.print(s);
				}
				break;
			case 's':
				LibraryApp.save();
				break;
			case 'l':
				LibraryApp.load();
				break;
			case 'e':
				LibraryApp.print("Thank you! Have a good day!");
				break;
			default:
				 LibraryApp.print("You have entered an invalid input.");
			}
				
	}

	@Override
	public void runSmenu(String ch2) {
		char ch1 = ' ';
		ch1 = ch2.toLowerCase().charAt(0);
		switch (ch1) {
		case 'a':
			LibraryApp.registerStudent();
			break;
		case 'b':
			String ID = JOptionPane.showInputDialog(null, "Enter your student ID: ");
			for (User s : LibraryApp.users) {
				if (s instanceof Student) {
					Student stu = (Student) s;
					if (stu.getID().equals(ID)) {
						String title = JOptionPane.showInputDialog(null, "Enter the name of the book that you want to borrow:");
						for (Book b : LibraryApp.books) {
							if (b.getTitle().equals(title)) {
								if(stu.borrowBook(b)) {
									LibraryApp.print("You have borrowed the book!");
								}
							}
						}
					}
				}
			}
			break;
		case 'r':
			String id1 = JOptionPane.showInputDialog(null, "Enter you student ID: ");
			String title1 = JOptionPane.showInputDialog(null, "Enter the title of the book you would like to return: ");
			for (User s : LibraryApp.users) {
				if (s instanceof Student) {
					Student stud = (Student) s;
					if (stud.getID().equals(id1)) {
						for (Book b : LibraryApp.books) {
							if (b.getTitle().equals(title1)) {
								stud.returnBook(b);
								int days = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of days you are returning the book after: "));
								if (days > 14) {
									stud.setFine((days-14) * 5);
								}
							}
						}
					}		
				}
			}
			break;
		case 'm':
			String id = JOptionPane.showInputDialog(null, "Enter your student ID: ");
			boolean userfound = false;
			for (User s : LibraryApp.users) {
				if (s instanceof Student) {
					Student stu = (Student) s;
					if (stu.getID().equals(id)) {
						userfound = true;
						stu.printBorrowedbooks();
						break;
					}
				}
			}
			if (!userfound)
				LibraryApp.print("User not found!");
			break;
		case 'd':
			for (Book b :  LibraryApp.books) {
				LibraryApp.print(b);
			}
			break;
		case 'f':
			String id2 = JOptionPane.showInputDialog(null, "Enter your student ID: ");
			for (User s : LibraryApp.users) {
				if (s instanceof Student) {
					Student stu = (Student) s;
					if (stu.getID().equals(id2)) {
						LibraryApp.print(stu.getName() + ", your pending fine is $" + stu.getFine());
					}
				}
			}
			break;
		case 'h':
			String n1 = JOptionPane.showInputDialog(null, "Enter the name of the book you are looking for: ");
			LibraryApp.searchBook(n1);
			break;
		case 'p':
			String ID1 = JOptionPane.showInputDialog(null, "Enter your student ID: ");
			double pay = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount you wanna pay: "));
			for (User s : LibraryApp.users) {
				if (s instanceof Student) {
					Student stu = (Student) s;
					if (stu.getID().equals(ID1)) {
						stu.payFine(pay);
					}
				}
			}
			break;
		case 's':
			LibraryApp.save();
			break;
		case 'l':
			LibraryApp.load();
			break;
		case 'e':
			LibraryApp.print("Thank YOU!");
			break;
		default:
			LibraryApp.print("Invalid input.");
		}	
	}

}
