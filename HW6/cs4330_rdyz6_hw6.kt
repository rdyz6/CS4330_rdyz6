   
/*name: Runnan Dong
 *pawprint: rdyz6
 *Date:March 4th*/
   const val sample1: Byte = 0x3A;
   var integral: Char = '\u222B';
   const val greeting = "Hello";
   fun main(args: Array<String>) {
    
    val sample2: Byte = 58;
    val heartRate: Int = 85;
    val deposits: Double = 135002796.0;
    val acceleration: Float = 9.800F;
    val mass: Float = 14.6F;
    val distance: Double = 129.763001;
    val force: Float = mass*acceleration;
    val lost: Boolean = true;
    val expensive: Boolean = true;
    val choice: Int = 2;
    var age:Int = 0;
    val name = "Karen";
    
    
    if (sample1 == sample2){
        println("The samples are equal");
    }else{
        println("The samples are not equal");
    }
    
    if (heartRate >= 40 && heartRate <=80){
        println("Heart rate is normal.")
    }
    else{
        println("Heart rate is not normal.")
    }
    if(deposits >= 100000000.0){
        println("You are exceedingly wealthy.")
    }
    else{
        println("Sorry you are so poor.")
    }
    
    println("Force = ${force}");
    println("${distance} is the distance");
    
    if(lost && expensive){
        println("I am really sorry! I will get the manager.")
    }else if(lost && !expensive){
        println("Here is coupon for 10% off.")
    }
    
    println(when (choice) {
        1 -> "you chose 1"
        2 -> "you chose 2"
        3 -> "you chose 3"
        else -> "You made an unknown choice."
    })
    println("${integral} is an integral")
    
    for(i in 5..10){
        println("i = ${i}");
    }
    
    while(age<6){
        println("age is ${age}.");
        age++;
    }
    println("${greeting} ${name}")
    
    
    
}