package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
import Managers.CollectionManager;

  /**
 * Команда count_less_than_impact_speed, выводит количество 
 * элементов, значение поля impactSpeed которых меньше заданного
 */
public class CountLessThanImpactSpeedCommand extends Command{
    private Console console;
    private CollectionManager collectionManager;
    public CountLessThanImpactSpeedCommand(Console console, CollectionManager collectionManager){
        super("count_less_than_impact_speed", "вывести количество элементов, значение поля impactSpeed которых меньше заданного");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args){
        if (args.length!=1){
            console.printError("Команда не требует аргументов!");
            return;
        }
        double counter = 0;
        for(Integer key : collectionManager.getCollection().keySet()){
            if (collectionManager.getCollection().get(key).getImpactSpeed() < Double.parseDouble(args[1])){
                counter += 1;
            }
        }
        console.print(counter);
        return;
    }
}