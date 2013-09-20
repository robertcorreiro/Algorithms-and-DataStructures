class WeightedQuickUnion
  attr_reader :id, :sz

  def initialize(num)
    @id = Array.new(num) { |index| index}
    @sz = Array.new(num, 1)
  end

  private  
  def rootOf i
    while i != id[i] do
      id[i] = id[id[i]]
      i = id[i]
    end
    i
  end

  public
  def connected?(i, j)
    rootOf(i) == rootOf(j)
  end

  def union(i, j)
    iRoot = rootOf i
    jRoot = rootOf j
     # i becomes a child of j when sizes equal
    if @sz[iRoot] <= @sz[jRoot]
      @id[iRoot] = jRoot
      @sz[jRoot] += @sz[iRoot]
    else
      @id[jRoot] = iRoot
      @sz[iRoot] += @sz[jRoot]
    end
  end
end