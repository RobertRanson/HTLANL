class Bill:
    
    standingcost = 25.00
    unitcost = 12.376
    billHeader = "**********BILL************\n"
    billFooter = "\n**************************\n"

    def __init__(self,powerused):
        self.powerused = powerused
        self.calculateCost()
        self.addStanding()
    
    def calculateCost(self):
        self.cost = self.powerused * Bill.unitcost
    
    def addStanding(self):
        self.bill = self.cost + Bill.standingcost
    
    def displayCost(self):
        print(Bill.billHeader)
        print("You used {:.2f}KwH this month".format(self.powerused))
        print("The cost of your bill is £{:.2f}".format(self.bill))
        print(Bill.billFooter)



def main():
    powerused = float(input("Enter units: "))
    myBill = Bill(powerused)
    myBill.displayCost()
    myBillTheSecond = Bill(21.32)
    myBillTheSecond.displayCost()

main()