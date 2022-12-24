package com.werner.bl.functionapp.codegeneration.model;

import com.werner.bl.functionapp.codegeneration.model.enums.FunctionAppClientType;
import com.werner.bl.functionapp.codegeneration.model.enums.FunctionAppTriggerType;
import com.werner.bl.resourcecreation.model.ResourceType;
import com.werner.bl.resourcecreation.model.graph.edge.ResourceEdge;
import com.werner.bl.resourcecreation.model.graph.node.EdgeType;
import org.springframework.stereotype.Component;

@Component
public class EdgeTypeMapper {

    public FunctionAppTriggerType computeResultingTriggerType (ResourceEdge edge) {
        ResourceType resourceType1 = edge.getResource1().getResourceType();
        ResourceType resourceType2 = edge.getResource2().getResourceType();
        EdgeType edgeType = edge.getEdgeType();

        if(resourceType1 == ResourceType.FUNCTION && resourceType2 == ResourceType.FUNCTION) {
            switch(edgeType) {
                case HTTP_GET:
                    return FunctionAppTriggerType.HTTP_GET;
                case HTTP_POST:
                    return FunctionAppTriggerType.HTTP_POST;
            }
        } else if(resourceType2 == ResourceType.FUNCTION) {
            switch(edgeType) {
                case SERVICE_BUS_PUB_SUB:
                    return FunctionAppTriggerType.SERVICE_BUS_PUB_SUB;
            }
        }
        return null;
    }

    public FunctionAppClientType computeResultingClientType(ResourceEdge edge) {
        ResourceType resourceType1 = edge.getResource1().getResourceType();
        ResourceType resourceType2 = edge.getResource2().getResourceType();
        EdgeType edgeType = edge.getEdgeType();

        if(resourceType1 == ResourceType.FUNCTION && resourceType2 == ResourceType.FUNCTION) {
            switch(edgeType) {
                case HTTP_GET:
                    return FunctionAppClientType.HTTP_GET;
                case HTTP_POST:
                    return FunctionAppClientType.HTTP_POST;
            }
        }

        return null;
    }
}
