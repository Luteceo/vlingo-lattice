// Copyright © 2012-2020 VLINGO LABS. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.xoom.actors;

import io.vlingo.xoom.lattice.grid.GridNodeBootstrap;
import io.vlingo.xoom.lattice.grid.application.GridActorControl;
import io.vlingo.xoom.lattice.grid.application.QuorumObserver;
import io.vlingo.xoom.lattice.grid.hashring.HashRing;
import io.vlingo.xoom.wire.node.Id;

public interface GridRuntime extends QuorumObserver {
  Actor actorAt(Address address);
  void relocateActors();
  Stage asStage();
  GridNodeBootstrap gridNodeBootstrap();
  HashRing<Id> hashRing();
  void nodeJoined(final Id newNode);
  QuorumObserver quorumObserver();
  void setNodeId(final Id nodeId);
  void setOutbound(final GridActorControl.Outbound outbound);
  World world();
  ClassLoader worldClassLoader();
}
