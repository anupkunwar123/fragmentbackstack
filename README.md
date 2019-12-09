# fragmentbackstack
It demostracted how we can use bottomnavigationview and keep the state of view while navigation between menu items 
FragmentTransacation allows us to add the transaction in back stack and when onBackPressed is called it's poped from the back stack thus giving us features like activity task stack. However, when we use BottomNavigationView we need different kind of behavior.  For example if users click on multiple item from BottomNavigationView then using FragmentTransaction back stack doesn't help at all. Every time user switches between menu item in BottomNavigationView a new fragment is created and existing state is lost. 

So how can we preserve fragment state when we add or remove fragment? Is is even possible and how does the app like Instagram does it?
