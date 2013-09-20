require 'spec_helper'
require_relative '../../src/union_find/WeightedQuickUnion'

describe WeightedQuickUnion do
  before :each do
    @uf = WeightedQuickUnion.new(10)
    @uf.union(1,2)
  end

  it 'should connect single nodes' do 
    @uf.id[1].should == 2
  end

  describe 'union' do
    before :each do
      @uf.union(5,6)
      @uf.union(4,6)
    end

    it 'should correctly connect leaves when the first tree is smaller' do
      @uf.union(1,4)
      @uf.id[2].should == 6
    end

    it 'should correctly connect leaves when the first tree is bigger' do
      @uf.union(5,1)
      @uf.id[2].should == 6
    end

    it 'should correctly connect nodes when the first tree is smaller' do
      @uf.union(2,6)
      @uf.id[2].should == 6
    end

    it 'should correctly connect nodes when the first tree is bigger' do
      @uf.union(6,2)
      @uf.id[2].should == 6
    end
  end

  describe 'connected?' do

  end

  it 'should respond to queries'
end