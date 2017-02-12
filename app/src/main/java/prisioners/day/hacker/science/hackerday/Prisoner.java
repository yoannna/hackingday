package prisioners.day.hacker.science.hackerday;

import java.util.List;
import java.util.ArrayList;

public class Prisoner {
    public String name;
    public int _totalYears;
    public int totalYears(){
        return this._totalYears;
    }
    public ArrayList<Action> _actions;
    public Action lastAction = Action.Co_operate;
    public ArrayList<Action> actions(){
        return this._actions;
    }
    public Prisoner(String name)
    {
        this.name = name;
        _actions = new ArrayList<Action>();
    }
    public void reward()
    {
        _totalYears += 2;
    }
    public void payoff()
    {
        _totalYears += 6;
    }
    public void punishment()
    {
        _totalYears += 4;
    }
    public void temptation()
    {
        _totalYears += 0;
    }
    public void defect()
    {
        _actions.add(Action.Defect);
        lastAction = Action.Defect;
    }
    public void co_operate()
    {
        _actions.add(Action.Co_operate);
        lastAction = Action.Co_operate;
    }
    public static void outcome(Prisoner prisoner1, Prisoner prisoner2)
    {
        int index = prisoner1._actions.size() - 1;
        if (prisoner1._actions.get(index) == Action.Co_operate && prisoner2._actions.get(index) == Action.Co_operate)
        {
            prisoner1.reward();
            prisoner2.reward();
        }
        if (prisoner1._actions.get(index) == Action.Co_operate && prisoner2._actions.get(index) == Action.Defect)
        {
            prisoner1.payoff();
            prisoner2.temptation();
        }
        if (prisoner1._actions.get(index) == Action.Defect && prisoner2._actions.get(index) == Action.Co_operate)
        {
            prisoner1.temptation();
            prisoner2.payoff();
        }
        if (prisoner1._actions.get(index) == Action.Defect && prisoner2._actions.get(index) == Action.Defect)
        {
            prisoner1.punishment();
            prisoner2.punishment();
        }
    }

}
