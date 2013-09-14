class WeightedQuickUnion
  def initialize(num)
    @id = Array.new(num)
    @sz = Array.new(num, 1)
    @id.each_with_index do |i, index|
      @id[index] = index
    end
  end
  
  def rootOf i
    while i != id[i] do
      id[i] = id[id[i]]
      i = id[i]
    end
    i
  end

  def connected?(i, j)
    rootOf i == rootOf j
  end

  def union(i, j)
    iRoot = rootOf i
    jRoot = rootOf j
    if @sz[iRoot] <= @sz[jRoot]
      @id[iRoot] = jRoot
      @sz[jRoot] += @sz[iRoot]
    else
      @id[jRoot] = iRoot
      @sz[iRoot] += @sz[jRoot]
    end
  end
end