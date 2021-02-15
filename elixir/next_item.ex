# https://www.codewars.com/kata/542ebbdb494db239f8000046/train/elixir

# Given a sequence of items and a specific item in that sequence, 
# return the item immediately following the item specified. 
# If the item occurs more than once in a sequence, return the item after the first occurence. 
# This should work for a sequence of any type.

# next_item([1, 2, 3, 4, 5, 6, 7], 3) #=> 4
# next_item(["Joe" "Bob" "Sally"], "Bob") #=> "Sally"

defmodule NextBigThing do
  def next_item(list, item) do
    # for Elixir implement only for List type
    mapping = Enum.zip(list , List.delete_at(list, 0)) |> Enum.into(%{})
    mapping[item]  
    end
end

IO.puts NextBigThing.next_item([1,2,3,4,5,6,7], 3)
IO.puts NextBigThing.next_item(["Joe", "Bob", "Sally"], "Bob")


# The BEST solution

defmodule NextBigThing do
  def next_item([], _item), do: nil
  def next_item([item, next | _rest], item), do: next
  def next_item([_any | rest], item), do: next_item(rest, item)
end
